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
      info:"",
      instytut:localStorage.getItem("instytut")
       };
  },
  methods:
  {
    "loadsubject":function(name)
    {
      localStorage.setItem("subject", name);
      window.location.href="/Faculty"
    },
    "logout":function(){
    localStorage.removeItem('user')
        location.reload();
},
  },
  mounted() {
    UserService.getFaculty(this.instytut).then(
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