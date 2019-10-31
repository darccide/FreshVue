<template>
  <div class="section">
    <div class="card is-clearfix columns">
        <figure class="card-image is-480x480 column is-one-thirds">
          <img :src="getImgUrl(item.image)" :alt="item.itemName" class="single-item-image">
        </figure>
        <div class="card-content column is-two-thirds">
          <div class="card-content">
            <h2 class="title is-1">{{ item.itemName }}</h2>
          </div>
          <div class="card-content">
            <p><span class="subtitle is-3">Description: {{ item.itemDescription }}</span></p>
          </div>
          <div class="card-content">
            <span class="title is-3"><strong>&#36;{{ item.price }}</strong></span>
          </div>
          <div class="card-content update-quantity">
            <p class="quantity">
              <button class="button update-num is-success" @click="quantity > 0 ? quantity-- : quantity = 0">-</button>
              <input class="input is-success" type="number" v-model="quantity" min="0" max="50" />
              <button class="button update-num is-success" @click="quantity++">+</button>
            </p>
          </div>
          <div class="card-content update-quantity">
            <p>
              <button class="button is-success is-light is-outlined">Add to Cart</button>
            </p>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

export default {
    head() {
        return {
            title: this.item.itemName,
            meta: [
                {
                    hid: 'description',
                    name: 'description',
                    content: 'What you need to know about ' + this.item.itemName
                }
            ]
        }
    },
    data() {
      return {
        quantity: 1,
      }
    },
    async fetch({ store, error, params }) {
        try {
            await store.dispatch('items/fetchItem', params.id)
        } catch(e) {
            error({ 
                statusCode: 503, 
                message: 'Unable to fetch item #' + params.id + ' at this time. Please try again.'
            })
        }
    },
    methods: {
        getImgUrl(image) {
            return require('../../assets/images/' + image)
        }
    },
    computed: {
      ...mapState({
        item: state => state.items.item
      }),
    }
}
</script>

<style lang="scss" scoped>
  .section {
    padding-top: 12em;
  }
  .single-item-image {
    height: 26em;
    width: 40em
  }
  .quantity {
    display: flex;
  }
  input {
  width: 3em;
  font-size: 25px;
  margin: 0 10px;
  padding: 5px 10px;
}
.update-num {
  font-size: 20px;
  width: 3em;
}
</style>