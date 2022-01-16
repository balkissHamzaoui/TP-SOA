const grpc=require('grpc');
const protoLoader= require('@grpc/proto-loader');
const packageDef=protoLoader.loadSync("users.proto",{});
const grpcObject=grpc.loadPackageDefinition(packageDef);
const userPackage=grpcObject.userPackage


const client=new userPackage.UserService('localhost:9000',grpc.credentials.createInsecure());




//GET ALL USERS
client.GetAll({},(err,response)=>{ 
    console.log('GET ALL USERS : Received from server '+JSON.stringify(response));
})


//CREATE USER
client.Create({
    'id': "3",
    name: "Karaa Eya",
    age: 25,
    address: "Boumhal"
},(err,response)=>{ 
    console.log('CREATE USER : Received from server '+JSON.stringify(response));
})


//GET USER
client.Get({
    'id': "1"
},(err,response)=>{ 
    console.log('GET USER : Received from server '+JSON.stringify(response));
})
//UPDATE USER
client.Update({
    id: "1",
    name: "Sayeh Hiba",
    age: 25,
    address: "Hammam - lif"
},(err,response)=>{ 
    console.log('UPDATE USER : Received from server '+JSON.stringify(response));
})
//GET ALL USERS
client.GetAll({},(err,response)=>{ 
    console.log('GET ALL USERS : Received from server '+JSON.stringify(response));
})
//DELETE USER
client.Delete({
    id: "2",
},(err,response)=>{ 
    console.log('DELETE USER : Received from server '+JSON.stringify(response));
})


//GET ALL USERS
client.GetAll({},(err,response)=>{ 
    console.log('GET ALL USERS : Received from server '+JSON.stringify(response));
})
