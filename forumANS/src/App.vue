<template>
  <div id="app">
    <header>
        <!--NavBar Section-->
        <div class="brand"><router-link to="/">FORUM ANS</router-link></div>
        <div class="brand right"><router-link to="/profile">🙍‍♂️</router-link>
        
        </div>

        
    </header>
    <div class="container">
      <router-view />
    </div>
  </div>
</template>
<script>
export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser['roles']) {
        return this.currentUser['roles'].includes('ROLE_ADMIN');
      }
      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser['roles']) {
        return this.currentUser['roles'].includes('ROLE_MODERATOR');
      }
      return false;
    }
  },
  methods: {
    logOut() {
      this.$store.dispatch('/logout');
      this.$router.push('/login');
    }
  }
};
</script>
<style src="./components/theme/style.css"></style>
