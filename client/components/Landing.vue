<template>
    <section class="hero is-info is-fullheight">
        <div class="hero-body">
            <div class="container has-text-centered">
                <div class="column is-6 is-offset-3">
                    <h1 class="title has-text-light">
                         Welcome to FreshVue, the newest Online grocery shopping application.
                    </h1>
                    <h2 class="subtitle has-text-light">
                        Let us give you a new perspective on all your grocery needs. Your experience will be hassle-free, efficient, and free of all of those pesky people at a brick and mortar grocery store.
                    </h2>
                </div>
            </div>
        </div>
    </section>
</template>
<style lang="scss" scoped>
    .hero.is-info {
        background: linear-gradient(
        rgba(0, 0, 0, 0.5),
        rgba(0, 0, 0, 0.5)
        ), url('../assets/images/landing.jpg') center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
.hero .nav, .hero.is-success .nav {
  -webkit-box-shadow: none;
  box-shadow: none;
}
.hero .subtitle {
  padding: 3rem 0;
  line-height: 1.5;
}
</style>