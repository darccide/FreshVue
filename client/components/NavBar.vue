<template>
    <div>
        <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
            <div class="container">
                <div class="navbar-brand">
                    <nuxt-link to="/" class="navbar-item has-text-success is-size-1">
                        FreshVue
                    </nuxt-link>
                    <label class="navbar-burger nav-toggle" for="nav-toggle-state">
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>
                </div>
                <input type="checkbox" id="nav-toggle-state" />
                <div id="navbarBasic" class="navbar-menu">
                    <div class="navbar-end">
                        <span class="navbar-item">
                            <nuxt-link class="button is-success is-outlined" to="/">
                                <span class="icon">
                                    <i class="fa fa-home"></i>
                                </span>
                                <span>Home</span>
                            </nuxt-link>
                        </span>
                        <span class="navbar-item">
                            <nuxt-link class="button is-success is-outlined" to="/market">
                                <span class="icon">
                                    <i class="fa fa-shopping-basket"></i>
                                </span>
                                <span>Market</span>
                            </nuxt-link>
                        </span>
                        <span class="navbar-item">
                            <div class="cartTotal" v-if="cartCount > 0">{{ cartCount }}</div>
                            <nuxt-link class="button is-success is-outlined" to="/cart">
                                <span class="icon">
                                    <i class="fa fa-shopping-cart"></i>
                                </span>
                                <span>Cart</span>
                            </nuxt-link>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</template>

<script>
    import { mapGetters } from 'vuex'
    export default {
        computed: {
            ...mapGetters(["items/cartCount"])
        }
    }
</script>

<style lang="scss" scoped>
#nav-toggle-state {
  display: none;
}

#nav-toggle-state:checked ~ .navbar-menu {
  display: block;
}

.carttotal {
  position: absolute;
  border-radius: 1000px;
  background: black;
  color: white;
  font-size: 10px;
  padding: 3px;
  top: -18px;
  right: -5px;
  width: 25px;
  text-align: center;
  height: 25px;
  font-size: 10px;
  padding: 6px 10px;
  font-weight: bold;
}
</style>