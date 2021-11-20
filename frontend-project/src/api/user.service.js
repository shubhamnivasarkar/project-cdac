import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/user';
const API_URL_ADD = 'http://localhost:8080/address';
class UserService {
  
  getPublicContent() {
    console.log(authHeader())
    return axios.get(API_URL +'/details',{headers:authHeader()});
  }

  Editprofile(userId,user) {
    return axios.put(API_URL + `/edit/${userId}`,user,{headers: authHeader()});
  }

  addEditAddress(Address){
    return axios.put(API_URL_ADD + `/updateUserAddress`,Address,{headers: authHeader()});
  }

  getAddress(){
    return axios.get(API_URL_ADD + `/userAddress`,{headers:authHeader()});
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader()});
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', {headers: authHeader()});
  }
}

export default new UserService();
