<template>
  <!--Topic Section-->
        <div class="topic-container">
            <!--Original thread-->
            <div class="head">
                <div  class="authors">Autor</div>
                <div class="content">Wątek: {{przedmiot[0]}}</div>
            </div>
            <div class="body">
                <div class="authors">
                    <div class="username"><a href=""></a></div>
                    <div>{{przedmiot[3]}}</div>
                    <div id="autor" class="autor train" >Punkty: <u id="pkt" @click="rateup">{{przedmiot[2]}}</u></div>
                    <!-- {{comments[0].content + " " + comments[0].rate + " "+ comments[0].user.nickname}} -->
                    
                    <div></div>
                </div>
                <div class="content">
                    {{przedmiot[1]}}
                    <div class="comment">
                        <button @click="comment">Skomentuj</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Comment Area-->
        <div class="comment-area hide" id="comment-area">
            <textarea name="comment" id="" placeholder="comment here ... "></textarea>
            <input type="submit" value="submit">
        </div>

        <!--Comments Section-->
        <div id="komm" class="comments-container">
            
        </div>
</template>
<script>
import UserService from "../services/user.service";
import AuthService from "../services/auth.service"
import VueJwtDecode from 'vue-jwt-decode'
import userService from "../services/user.service";

export default {
  name: "Home",
  data() {
    return {
      content: "",
      comments:"",
      przedmiot:localStorage.getItem("subject").split(","),
      
      //items:["Instytut Informatyki Stosowanej","Instytut Politechniczny","Instytut Pedagogiczno-Językowy"],
    };
  },
  methods:
  {
    "rateup":function(){
      userService.incrementRate(this.przedmiot[0])
      this.przedmiot[2]++;
},
    "loadcomments":function(ile){

for(var i=0;i<ile;i++){
        var comm = '<div class="body">'+
                '<div class="authors">'+
                    '<div class="username">'+this.comments[i].user.nickname+'</div>'+
                    '<div>Student</div>'+
                    '<img id="id'+i+'" src="'+this.comments[i].user.icon+'" alt="">'+
                    '<div>Punkty: <u>'+this.comments[i].rate+'</u></div>'+
                '</div>'+
                '<div class="content">'+this.comments[i].content+
                '</div>'+
            '</div>';

            document.getElementById("komm").innerHTML+=comm;
           
            
}
              for(var i=0;i<this.comments.length;i++)
              {
                if(document.getElementById('id'+i).src=='http://localhost:8091/null'){
                document.getElementById('id'+i).src='https://bmspolska.pl/wp-content/uploads/2020/05/unnamed.png';
                }
              }

    },
    "infoimg":function(){
    if(this.przedmiot[4]!="")
    {
 document.getElementById("autor").style.backgroundImage="url('"+this.przedmiot[4]+"')";

    }
},
    "comment":function(){
     // var title = prompt("tytuł komentarza");
      var text = prompt("treść komentarza");
      var autor = VueJwtDecode.decode(this.$store.state.auth.user.access_token).sub
      var name = this.przedmiot[0];
        AuthService.sendcomment(JSON.stringify({commentary:{id:null,content:text,rate:0},trainName:name,userEmail:autor}));
     window.location.href="/Temat"
    },
    "logout":function(){
    localStorage.removeItem('user')
        location.reload();
},
  },
  mounted() {
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
  this.$nextTick(() => {
        this.infoimg();
              

      });
      UserService.getComment(this.przedmiot[0]).then(
      (response) => {
        this.comments = response.data;
        console.log(this.comments);
         this.loadcomments(this.comments.length)
      },
      (error) => {
        this.comments =
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