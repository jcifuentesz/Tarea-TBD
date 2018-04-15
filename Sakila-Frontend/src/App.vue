<template>
  <div>
    <header>
      <div class="branding">
        <img class ="logo-small" src="./img/fidget-spinner.svg" />
        <span>Nagevación superior</span>
      </div>
      <nav>
        <a href="#/">Home</a>
        <a href="#/actors">Lista</a>
        <a href="#/new_actor">Nuevo actor</a>
      </nav>
    </header>

    <main class="container">
      <router-view></router-view>
    </main>
    <footer>
      Footer
    </footer>
</div>
</template>

<script>
export default {

}
</script>
