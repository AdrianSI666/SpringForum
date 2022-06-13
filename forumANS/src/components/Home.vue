<template>
  <div class="container">
    <header class="jumbotron">
      <h1 class="big">INSTYTUTY</h1>
<div v-for="item in items"  class="subforum">
            <div class="subforum-title pointer">
                <h1 @click="instytut(item.name)">{{item.name}}</h1>
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
      items:[]
};
  },
  methods:
  {
    "instytut":function(a){
      localStorage.setItem("instytut",a);
      location.href="instytut ";
  },
    "logout":function(){
    localStorage.removeItem('user')
        location.reload();
},
  },
  mounted() {
    UserService.getInstitute().then((response)=>{
    this.items=response.data;
    console.log(response.data);
  }).catch((e)=>{this.items=e;});
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