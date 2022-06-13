import axios from 'axios';
import authHeader from './auth-header';
const API_URL = 'http://localhost:8090/api';
class UserService {
  getPublicContent() {
    return axios.get(API_URL + '/users');
  
  }

  getInstitute(){
    return axios.get(API_URL+'/institutes',{ headers: authHeader() });
  }
  getInstituteByName(name){
    return axios.get(API_URL+`/institute/find/${name}`,{ headers: authHeader() });
  }
  getFaculty(name){
    return axios.get(API_URL+`/faculty/find?institute=${name}`,{ headers: authHeader()});
  }
  getYear(name){
    return axios.get(API_URL+`/year/find?faculty=${name}`,{ headers: authHeader()});
  }
  getComment(data) {
    //debugger
    return axios
      .get(API_URL + `/comment/findByTrain?train=${data}`,{headers: authHeader()})
    
  }
  incrementRate(name) {
    //debugger
    return axios
      .get(API_URL + `/train/increment/${name}`,{headers: authHeader()})
    
  }
  
  getSubject(name){
    return axios.get(API_URL+`/subject/find?year=${name}`,{ headers: authHeader()});
  }
  getTrain(name){
    return axios.get(API_URL+`/train/find?subject=${name}`,{ headers: authHeader()});
  }
  getRating(name){
    return axios.get(API_URL+`/user/rating/${name}`,{ headers: authHeader()});
  }

   getThisUser(user) {
    return axios.get(`http://localhost:8090/api/user/find/${user}`,{ headers: authHeader() });     
  }
  test()
  {
    return axios.get('http://localhost:8090/api/user/find/ania@test.pl',{ headers: authHeader() });
  }
//   getUserBoard() {
//     return axios.get(API_URL + 'user', { headers: authHeader() });
//   }
//   getModeratorBoard() {
//     return axios.get(API_URL + 'mod', { headers: authHeader() });
//   }
//   getAdminBoard() {
//     return axios.get(API_URL + 'admin', { headers: authHeader() });
//   }
}
export default new UserService();
