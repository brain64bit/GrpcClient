package sip_server;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: sip_server.proto")
public final class ActionGrpc {

  private ActionGrpc() {}

  public static final String SERVICE_NAME = "sip_server.Action";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<sip_server.SipServer.Request,
      sip_server.SipServer.Response> METHOD_SEND_MESSAGE = getSendMessageMethod();

  private static volatile io.grpc.MethodDescriptor<sip_server.SipServer.Request,
      sip_server.SipServer.Response> getSendMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<sip_server.SipServer.Request,
      sip_server.SipServer.Response> getSendMessageMethod() {
    io.grpc.MethodDescriptor<sip_server.SipServer.Request, sip_server.SipServer.Response> getSendMessageMethod;
    if ((getSendMessageMethod = ActionGrpc.getSendMessageMethod) == null) {
      synchronized (ActionGrpc.class) {
        if ((getSendMessageMethod = ActionGrpc.getSendMessageMethod) == null) {
          ActionGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<sip_server.SipServer.Request, sip_server.SipServer.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sip_server.Action", "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sip_server.SipServer.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sip_server.SipServer.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ActionMethodDescriptorSupplier("sendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ActionStub newStub(io.grpc.Channel channel) {
    return new ActionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ActionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ActionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ActionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ActionFutureStub(channel);
  }

  /**
   */
  public static abstract class ActionImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessage(sip_server.SipServer.Request request,
        io.grpc.stub.StreamObserver<sip_server.SipServer.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                sip_server.SipServer.Request,
                sip_server.SipServer.Response>(
                  this, METHODID_SEND_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class ActionStub extends io.grpc.stub.AbstractStub<ActionStub> {
    private ActionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ActionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ActionStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(sip_server.SipServer.Request request,
        io.grpc.stub.StreamObserver<sip_server.SipServer.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ActionBlockingStub extends io.grpc.stub.AbstractStub<ActionBlockingStub> {
    private ActionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ActionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ActionBlockingStub(channel, callOptions);
    }

    /**
     */
    public sip_server.SipServer.Response sendMessage(sip_server.SipServer.Request request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ActionFutureStub extends io.grpc.stub.AbstractStub<ActionFutureStub> {
    private ActionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ActionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ActionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sip_server.SipServer.Response> sendMessage(
        sip_server.SipServer.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ActionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ActionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((sip_server.SipServer.Request) request,
              (io.grpc.stub.StreamObserver<sip_server.SipServer.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ActionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ActionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sip_server.SipServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Action");
    }
  }

  private static final class ActionFileDescriptorSupplier
      extends ActionBaseDescriptorSupplier {
    ActionFileDescriptorSupplier() {}
  }

  private static final class ActionMethodDescriptorSupplier
      extends ActionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ActionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ActionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ActionFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
