<template>
  <div class="container">
    <header class="jumbotron">
      <div id='avatar' class="image-container" >{{infoimg()}}</div>
      <div id='rate'>{{rating}}</div>
      <h3 class='tagname'>{{info.nickname}}</h3>
      <h3>E-mail:{{  userdata().sub }}</h3>
      <h3>Rola:{{  userdata().roles[0] }}</h3>
      <h3>Index: {{info.indeks}}</h3>
      <p class="article">{{info.description}}</p>
    <div @click="logout" id="logout"></div>
    </header>
  </div>
</template>
<script>
import VueJwtDecode from 'vue-jwt-decode'
import UserService from "../services/user.service"

export default {
  name: 'Profile',
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
    
  },data(){
    return {
      info:"d",
      rating:""
    }
  },
  
  methods:
  {
    "logout":function(){
    localStorage.removeItem('user')
        location.reload();
},
"ratecolor":function(rate){
    if(ParseIrate>0)
    document.getElementById("rate").style.fontcolor("green");
    else if(rate<0)
    document.getElementById("rate").style.fontcolor("red");
  },
"userdata":function(){
  
  return VueJwtDecode.decode(this.$store.state.auth.user.access_token);
},
"thisuserdata":function(ud){
  return UserService.getThisUser(ud.sub)
  .then((response)=>{
    this.info=response.data;

    console.log(response.data);
  }).catch((e)=>{console.log(e);});
},
"infoimg":function(){
    if(this.info.icon!=null)
    {
 document.getElementById('avatar').style.backgroundImage="url('"+this.info.icon+"')";
    }
}
  },
   mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
      
    
    }

  
     
  UserService.getThisUser(this.userdata().sub)
  .then((response)=>{
    this.info=response.data;
    console.log(response.data);
    
  }).catch((e)=>{this.info=e;});
   UserService.getRating(this.userdata().sub)
  .then((response)=>{
    this.rating=response.data;
    console.log(response.data);
    
  }).catch((e)=>{this.rating=e;});
  }
};
</script>
