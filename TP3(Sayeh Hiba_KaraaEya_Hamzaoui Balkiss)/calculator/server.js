const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');
const packageDef = protoLoader.loadSync("calculator.proto", {});
const grpcObject = grpc.loadPackageDefinition(packageDef);
const calculatorPackage = grpcObject.calculatorPackage;

const server = new grpc.Server();

//server implements the methods declared in todo.proto

server.bind('localhost:9000', grpc.ServerCredentials.createInsecure());
server.addService(calculatorPackage.Calculator.service,
    {
        'Addition' : Addition,
        'Subtraction':Subtraction,
        'Multiplication':Multiplication,
        'Division':Division,
    });

    server.start();
    let result=0;

    function Addition(call, callback) {
        const params = {
            'First' : call.request.First,
            'Second' : call.request.Second
        }
        result=params.First+params.Second;
        callback(null,{
            'result':result
       });
    }

    function Subtraction(call, callback) {
        const params = {
            'First' : call.request.First,
            'Second' : call.request.Second
        }
         result=params.First-params.Second;
        callback(null, {
            'result':result
       });
    }

    function Multiplication(call, callback) {
        const params = {
            'First' : call.request.First,
            'Second' : call.request.Second
        }
        result=params.First*params.Second;
        callback(null, {
            'result':result
       });
    }

    function Division(call, callback) {
        const params = {
            'First' : call.request.First,
            'Second' : call.request.Second
        }
        result=params.First/params.Second;
        callback(null, {
            'result':result
       });
    }
