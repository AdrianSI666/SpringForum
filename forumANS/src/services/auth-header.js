export default function authHeader(name=0) {
    let user = JSON.parse(localStorage.getItem('user'));
    if (user && user.access_token) {
      //console.log('Bearer ' + user.access_token);
      //return { Authorization: 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmlhQHRlc3QucGwiLCJyb2xlcyI6WyJVc2VyIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA5MC9hcGkvbG9naW4iLCJleHAiOjE2NTI0Njg5Mzl9.M5zrq1cPeJZZTX4BAdlEtboJHoU6TD-b3UNHHeO0pzo' };
     if(name="json")
     {
      return { Authorization: 'Bearer ' + user.access_token, "Content-Type":"application/json" };
     }
      return { Authorization: 'Bearer ' + user.access_token };
     
      
    } else {
      return {};
    }
  }
  
  