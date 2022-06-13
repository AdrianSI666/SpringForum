<template>
   <div class="container">
    <header class="jumbotron">
<div class="subforum">
  <h1 class="big">{{instytut}}</h1>
            <div v-for="item in info" class="subforum-title">
                <h1 class="przedmiot" @click="loadsubject(item.name)">{{item.name}}</h1>
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
      localStorage.setItem("subject", name);
      window.location.href="/Przedmiot"
    },
    "logout":function(){
    localStorage.removeItem('user')
        location.reload();
},
  },
  mounted() {
     UserService.getSubject(this.przedmiot).then(
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