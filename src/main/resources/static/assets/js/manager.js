//const API = 'http://localhost:8080';
const API = 'http://129.159.121.184:8080';

//Save
const AdminSave = API + '/api/Admin/save';
const CategorySave = API + '/api/Category/save';
const ClientSave = API + '/api/Client/save';
const QuadbikeSave = API + '/api/Quadbike/save';
const MessageSave = API + '/api/Message/save';
const ReservationSave = API + '/api/Reservation/save';

//Remove
const Reservation = API + '/api/Reservation/'
const MessageRemove = API + '/api/Message/';
const ClientRemove = API + '/api/Client/';
const QuadbikeRemove = API + '/api/Quadbike/';
const AdminRemove = API + '/api/Admin/';
const CategoryRemove = API + '/api/Category/';

//Id
const ClientId = API + '/api/Client/';
const QuadbikeId = API + '/api/Quadbike/';
const CategoryId = API + '/api/Category/';
const MessageId = API + '/api/Message/';
const ReservaId = API + '/api/Reservation/';
const AdminId = API + '/api/Admin/'

//All
const CategoryAll = API + '/api/Category/all';
const ClientAll = API + '/api/Client/all';
const QuadbikeAll = API + '/api/Quadbike/all';
const MessageAll = API + '/api/Message/all';
const ReservationAll = API + '/api/Reservation/all';

//Update
const QuadBikeUpdate = API + '/api/Quadbike/update';
const ClientUpdate = API + '/api/Client/update';
const MessageUpdate = API + '/api/Message/update';
const CategoryUpdate = API + '/api/Category/update';
const ReservationUpdate = API + '/api/Reservation/update'
const Admin = API + '/api/Admin/update';

//InfoS
const ReservationReport_dates = API + '/api/Reservation/report-dates/';
const ReservationReport_status = API + '/api/Reservation/report-status';
const ReservationReport_clients = API + '/api/Reservation/report-clients';

//Login
const User = API + '/user';

function doOpen(url) {
    document.location.target = "_blank";
    document.location.href = url;
}

async function salir() {
    await fetch(API + "/logout", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
}