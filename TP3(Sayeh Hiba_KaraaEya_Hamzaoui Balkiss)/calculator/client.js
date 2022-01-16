const grpc=require('grpc');
const protoLoader= require('@grpc/proto-loader');
const packageDef=protoLoader.loadSync("calculator.proto",{});
const grpcObject=grpc.loadPackageDefinition(packageDef);
const calculatorPackage=grpcObject.calculatorPackage


const client=new calculatorPackage.Calculator('localhost:9000',grpc.credentials.createInsecure());

client.Addition({ 
    'First':5.35,
    'Second':6.35,
},(err,response)=>{ 
    console.log('Aaddition : Received from server '+JSON.stringify(response));
})

client.Subtraction({ 
    'First':12.19,
    'Second':5.9,
},(err,response)=>{ 
    console.log('Subtraction : Received from server '+JSON.stringify(response));
})

client.Multiplication({ 
    'First':13,
    'Second':5.6,
},(err,response)=>{ 
    console.log('Multiplication : Received from server '+JSON.stringify(response));
})

client.Division({ 
    'First':10,
    'Second':2,
},(err,response)=>{ 
    console.log('Division : Received from server '+JSON.stringify(response));
})


