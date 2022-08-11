import axios from '../axios';
const getAllAuctions = (inputId) => {
    return axios.get('/Auctions' ,{id : inputId});
}

export {getAllAuctions}