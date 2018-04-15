<template lang="html">
  <div id="actor-data">
    <form v-if="!registered">
      <h2>{{title}}</h2>
      <label>Nombre:</label>
      <input type="text" v-model="firstName" placeholder="Ejemplo: Will" required>
      <label>Apellido:</label>
      <input type="text" v-model="lastName" placeholder="Ejemplo: Smith" required>
      <div class="center">
          <button v-on:click.prevent="post" name="registered">Registrar</button>
      </div>
    </form>

    <div v-if="registered">
      <h2>¡{{firstName}} {{lastName}} fue registrado con exito!</h2>
      <div class="center">
          <button v-on:click.prevent="back" name="back">Regresar</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      title:'Registre los datos del nuevo actor',
      firstName:'',
      lastName:'',
      users:[],
      registered:false
    }
  },
  methods:{
    post:function(){
      //Post method
      this.$http.post('http://localhost:8081/sakila-spring-backend/actors',{
        firstName:this.firstName,
        lastName:this.lastName
      }).then(function(data){
        console.log(data);
        this.registered = true;
      })
    },
    back:function(){
      this.registered = false;
      this.firstName = '';
      this.lastName = '';
    }
  }
}
</script>

<style lang="css">
#actor-data *{
    box-sizing: border-box;
}
#actor-data{
    margin: 20px auto;
    max-width: 500px;
}
label{
    display: block;
    margin: 20px 0 10px;
    font-weight: bold;
}
input[type="text"]{
    display: block;
    width: 100%;
    padding: 8px;
}
</style>
