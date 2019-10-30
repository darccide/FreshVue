<template>
  <div class="section">
    <div class="card is-clearfix columns">
        <figure class="card-image is-480x480 column is-one-thirds">
          <img :src="getImgUrl(item.image)" :alt="item.itemName">
        </figure>
        <div class="card-content column is-two-thirds">
          <div class="card-content__title">
            <h2 class="title is-4">{{ item.itemName }}</h2>
          </div>
          <div class="card-content__text">
            <p>{{ item.itemDescription }}</p>
          </div>
          <div class="card-content">
            <span class="title is-3"><strong>&#36;{{ item.price }}</strong></span>
          </div>
          <div class="card-content">
            <span class="title is-5"><strong>Inventory: {{ item.inventory }}</strong></span>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

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
    computed: mapState({
        item: state => state.items.item
    })
}
</script>

<style lang="scss" scoped>

</style>