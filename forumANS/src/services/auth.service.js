import axios from 'axios';
const API_URL = 'http://localhost:8090/api';
import authHeader from './auth-header';

class AuthService {
  login(user) {
    //debugger
    return axios
      .post(API_URL + '/login',
      new URLSearchParams({
        email: user.username,
        password: user.password
      }), {
        headers: { 
          "Content-Type": "application/x-www-form-urlencoded"
      }
      })
      //  {
      //   username: user.username,
      //   password: user.password
      // })
      .then(response => {
        // debugger
        // console.log(response.data);
        if (response.data.access_token) {
          
          
          localStorage.setItem('user', JSON.stringify(response.data));
        }
        return response.data;
      });
  }
  logout() {
    localStorage.removeItem('user');
  }
  register(user) {
    return axios.post(API_URL + '/registration', {
      username: user.username,
      email: user.email,
      password: user.password
    });
  }
  sendcomment(data) {
    //debugger
    return axios
      .post(API_URL + '/commentary/save',data,{headers: authHeader("json")})
    
  }
  

}
export default new AuthService();