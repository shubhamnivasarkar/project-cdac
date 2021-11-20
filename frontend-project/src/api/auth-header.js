export default function authHeader() {
    const token =localStorage.getItem('jwtToken');
    if (token !== null) {
       return { Authorization: 'Bearer ' + token }; // for Spring Boot back-end
   
    } else {
      return {};
    }
  }
  
