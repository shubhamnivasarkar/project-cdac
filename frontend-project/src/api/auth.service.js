import axios from 'axios'


const API_URL = "http://localhost:8080/user/";


class AuthService {

  login(email, password) {
    return axios
      .post(API_URL + "login", {
        email,
        password
      })
      .then(response => {
        if (response.data.token) {
          localStorage.setItem("jwtToken",response.data.token);
          localStorage.setItem("user",JSON.stringify(response.data.data))
        }
        return response.data.data;
      });
  }

  logout() {
    localStorage.removeItem("jwtToken");
    localStorage.clear();
  }

  register(firstName,lastName, email, password,role) {
    return axios.post(API_URL + "register", {
      firstName,
      lastName,
      email,
      password,
      role,
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));
  }
}

export default new AuthService();
