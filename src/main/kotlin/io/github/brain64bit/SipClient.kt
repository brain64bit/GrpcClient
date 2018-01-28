package io.github.brain64bit

import io.grpc.netty.NettyChannelBuilder
import io.grpc.stub.StreamObserver
import io.grpc.util.RoundRobinLoadBalancerFactory
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import mu.KotlinLogging
import sip_server.ActionGrpc
import sip_server.SipServer
import java.util.*
import java.util.concurrent.*

class SipClient {
    private val resultList: List<Future<Long>>
    private val threadPoolExecutor: ThreadPoolExecutor

    init {
        resultList =  ArrayList<Future<Long>>()
        threadPoolExecutor = ThreadPoolExecutor(
                THREAD_QTY,
                THREAD_QTY,
                Long.MAX_VALUE,
                TimeUnit.DAYS,
                LinkedBlockingQueue<Runnable>()
        )
    }

    class ClientExecutor: Callable<Long>{
        override fun call(): Long {
            val workerEventLoopGroup = NioEventLoopGroup(2)
            val threadPoolExecutor = ThreadPoolExecutor(
                    2,
                    2,
                    (1000 * 60 * 10).toLong(),
                    TimeUnit.MILLISECONDS,
                    LinkedBlockingQueue(65536))
//            val metricRegistry = MetricRegistry()
//            val metricsClientInterceptor = MetricsClientInterceptor()
//            metricsClientInterceptor.setStopwatchSupplier(GrpcUtil.STOPWATCH_SUPPLIER)
//            metricsClientInterceptor.setMetricRegistry(metricRegistry)
//            metricsClientInterceptor.setSlowCallTimeThreshold(20L)
            val managedChannel = NettyChannelBuilder
                    .forAddress(SERVER_ADDRESS, SERVER_PORT)
                    .eventLoopGroup(workerEventLoopGroup)
                    .channelType(NioSocketChannel::class.java)
                    .executor(threadPoolExecutor)
                    .loadBalancerFactory(RoundRobinLoadBalancerFactory.getInstance())
                    .flowControlWindow(1024 * 1024 * 1)
                    .maxHeaderListSize(1024 * 8)
                    .idleTimeout((1000 * 60 * 10).toLong(), TimeUnit.MILLISECONDS)
                    .keepAliveTime((1000 * 60 * 10).toLong(), TimeUnit.MILLISECONDS)
                    .keepAliveTimeout((1000 * 30).toLong(), TimeUnit.MILLISECONDS)
                    .usePlaintext(true)
//                    .intercept(metricsClientInterceptor)
                    .build()
            val shouldStop = false
            val stub = ActionGrpc.newStub(managedChannel)

            while(!shouldStop){
                val data = "Tidak seperti anggapan banyak orang, Lorem Ipsum bukanlah teks-teks yang diacak. Ia berakar dari sebuah naskah sastra latin klasik dari era 45 sebelum masehi, hingga bisa dipastikan usianya telah mencapai lebih dari 2000 tahun. Richard McClintock, seorang professor Bahasa Latin dari Hampden-Sidney College di Virginia, mencoba mencari makna salah satu kata latin yang dianggap paling tidak jelas, yakni consectetur, yang diambil dari salah satu bagian Lorem Ipsum."
                val countDownLatch = CountDownLatch(WINDOW_SIZE)
                val request: SipServer.Request = SipServer.Request
                        .newBuilder()
                        .setBody(data)
                        .setFrom("foobar")
                        .setTo("barbaz")
                        .build()
                val streamObserver: StreamObserver<SipServer.Response> = object : StreamObserver<SipServer.Response> {
                    override fun onNext(response: SipServer.Response?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onError(throwable: Throwable) {
                        LOGGER.error("test failed.", throwable)

                        countDownLatch.countDown()
                    }

                    override fun onCompleted() {
                        countDownLatch.countDown()
                    }
                };

                stub.sendMessage(request, streamObserver)
            }
            return 0L
        }

    }

    companion object {
        private val LOGGER = KotlinLogging.logger(SipClient::class.java.name)
        private val THREAD_QTY = 10
        private val SERVER_ADDRESS = "localhost"
        private val SERVER_PORT = 50051
        private val WINDOW_SIZE = 50

        @JvmStatic
        fun main(args: Array<String>){
            val client = SipClient()
        }
    }


}