const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');
const packageDef = protoLoader.loadSync("users.proto", {});
const grpcObject = grpc.loadPackageDefinition(packageDef);
const userPackage = grpcObject.userPackage;

const server = new grpc.Server();

const users=[{
    id: "1",
    name: "Sayeh Hiba",
    age: 24,
    address: "Hammam-lif"
},
{
    id: "2",
    name: "Hamzaoui Balkiss",
    age: 25,
    address: "Rades"
}];

server.bind('localhost:9000', grpc.ServerCredentials.createInsecure());
server.addService(userPackage.UserService.service,
    {
        'GetAll' : GetAll,
        'Get' :Get,
        'Create':Create,
        'Update':Update,
        'Delete':Delete
    });

    server.start();

    //GET ALL USERS
    function GetAll(call, callback) {

        callback(null,{
            'users':users
       });
    }

    //GET USER BY ID
    function Get(call, callback) {

        let user = users.find(user => user.id == call.request.id);

        if (user) {
            callback(null, user);
        } else {
            callback({
                code: grpc.status.NOT_FOUND,
                details: "User Not found"
            });
        }
    }

    //CREATE USER
    function Create (call, callback) {
        let user = call.request;
        
        users.push(user);
        callback(null, user);
    }

    //UPDATE USER
    function Update (call, callback) {
        let user = users.find(user => user.id == call.request.id);

        if (user) {
            user.name = call.request.name;
            user.age = call.request.age;
            user.address = call.request.address;
            callback(null, user);
        } else {
            callback({
                code: grpc.status.NOT_FOUND,
                details: "User Not found"
            });
        }
    }

    //DELETE USER
    function Delete (call, callback)  {

        let user= users.findIndex(
            user => user.id == call.request.id
        );

        if (user != -1) {
            users.splice(user, 1);
            callback(null, {"Message":"User with id "+user+" Deleted"});
        } else {
            callback({
                code: grpc.status.NOT_FOUND,
                details: "User Not found"
            });
        }
    }



