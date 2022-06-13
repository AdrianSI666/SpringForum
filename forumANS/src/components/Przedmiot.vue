<template>
  <div class="container">
    <header class="jumbotron">
<div class="subforum">
  <h1 class="big">{{przedmiot}}</h1>
            <div class="subforum-title">
                <h1>Tematy</h1>
            </div>
            <div v-for="item in info"  class="subforum-row">
                <div class="subforum-icon subforum-column center">
                    <i class="fa fa-keyboard-o center">{{item.rate}}</i>
                  
                </div>
                <div class="subforum-description subforum-column">
                    <h4 @click="loadsubject(item)" ><a href="#">{{item.name}}</a></h4>
                    <p>{{item.content.slice(0,30)}}</p>
                </div>
                
                
            </div>
        </div>
     <div @click="logout" id="logout"></div>
    </header>
  </div>
</template>
<script>
import UserService from "../services/user.service";
export default {
  name: "Home",
  data() {
    return {
      content: "",
      przedmiot:localStorage.getItem("subject"),
      info:""
      //items:[{title:"Instytut Informatyki Stosowanej",subitems:[{title:"X rok Y kierunek",title2:"Miejsce dla wszystkich studentów 1. roku..."}]},{title:"Instytut Informatyki Stosowanej",subitems:[{title:"X rok Y kierunek",title2:"Miejsce dla wszystkich studentów 1. roku..."}]},{title:"Instytut Informatyki Stosowanej",subitems:[{title:"X rok Y kierunek",title2:"Miejsce dla wszystkich studentów 1. roku..."}]},{title:"Instytut Informatyki Stosowanej",subitems:[{title:"X rok Y kierunek",title2:"Miejsce dla wszystkich studentów 1. roku..."}]},{title:"Instytut Informatyki Stosowanej",subitems:[{title:"X rok Y kierunek",title2:"Miejsce dla wszystkich studentów 1. roku..."}]},{title:"Instytut Informatyki Stosowanej",subitems:[{title:"X rok Y kierunek",title2:"Miejsce dla wszystkich studentów 1. roku..."}]},]
      //items:["Instytut Informatyki Stosowanej","Instytut Politechniczny","Instytut Pedagogiczno-Językowy"],
    };
  },
  methods:
  {
    "loadsubject":function(name)
    {
      var arr = [name.name,name.content,name.rate,name.user.nickname,name.user.icon]
      localStorage.setItem("subject",arr );
      window.location.href="/Temat"
    },
    "logout":function(){
    localStorage.removeItem('user')
        location.reload();
},
  },
  mounted() {
     UserService.getTrain(this.przedmiot).then(
      (response) => {
        this.info = response.data;
      },
      (error) => {
        this.content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );
    UserService.getPublicContent().then(
      (response) => {
        this.content = response.data;
      },
      (error) => {
        this.content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );
  },
};
</script>