<template>
  <div class="modal" :class='openModal'>
    <div class="modal-background"></div>
    <div class="modal-card">
      <header class="modal-card-head">
        <p class="modal-card-title">Your Cart</p>
        <button class="delete" aria-label="close" @click='close'></button>
      </header>
      <section class="modal-card-body">
        <ul>
          <li v-for="item in cart" :key="item.itemId" class="media">
            <img :src="getImgUrl(item.image)" :alt="item.itemName" class="cart-image"/>
              <h5 class="cart-item">{{ item.itemName }}</h5>
                <div class="media-body">
                  <h5 class="cart-price">&#36;{{ item.price }} | Quantity: {{ item.quantity }}</h5>                  
                    <!-- <span class='float-right' @click="$store.commit('removeFromCart',item)">X</span> -->
                </div>
          </li>
        </ul>
      </section>
      <footer class="modal-card-foot">
        <button class="button is-info" @click='close'>Continue Shopping</button>
        <nuxt-link to="/checkout" class="button is-primary" @click='close'>
          <button class="button is-primary" @click='close'>
            Checkout
          </button>
        </nuxt-link>
      </footer>
    </div>
  </div>
</template>

<script>
  import { mapState } from 'vuex'
  export default {
    props:['openModal'],
    methods: {
      close() {
        this.$emit('closeRequest')
      },
      getImgUrl(image) {
            return require('../assets/images/' + image)
      }
    },
    computed: {
      ...mapState({
        cart: state => state.items.cart
      })
    }
  }
</script>

<style lang="scss" scoped>
  .cart-image {
    width: 4em;
    height: 3em;
    padding-right: 1em;
  }
  .cart-item {
    padding-right: 1em;
  }
</style>