
<template src="../components/html/login.html">
</template>
<!-- <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:ital@1&display=swap" rel="stylesheet"> -->
<style src="../components/theme/style.css"></style>


<script>
import axios from 'axios'
const instance = axios.create({
  baseURL: 'http://localhost:8090',
  timeout: 100000,
  headers: {
      "Origin":"http://localhost:8090",
       "Content-Type":"application/json",
       "Accept": "*/*",
        "Authorization":"Basic",
        "Access-Control-Allow-Origin":"http://localhost:8090",
          "Access-Control-Allow-Credentials":"true"
  }});
export default {
    data(){
        return{
            info:""
        }
    },
methods:{
    login:function(){
        
instance.get('/api/login',{"email":"ania@test.pl","password":"ania"}).then(response => (this.info = response))
    console.log(this.info);
    }
}
}
</script>


