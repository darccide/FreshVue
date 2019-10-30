<template>
  <nuxt-link :to="'/item/' + item.itemId">
    <div class="card column is-one-thirds">
      <div class="card-image">
        <figure class="image is-4by3">
          <img :src="getImgUrl(item.image)" :alt="item.itemName">
        </figure>
      </div>
      <div class="card-content">
        <div class="media">
          <div class="media-content">
            <p class="title is-2">{{ item.itemName }}</p>
          </div>
          <p class="is-pulled-right">
            <span class="title is-2">Price &#36;{{ item.price }}</span>
          </p>
        </div>
        <div class="card-footer">
          <div class="card-footer-item field is-grouped">
          </div>
        </div>
      </div>
    </div>
  </nuxt-link>
</template>

<script>
export default {
  name: 'ItemCard',
  props: {
      item: Object
  },
  methods: {
    getImgUrl(image) {
      return require('../assets/images/' + image)
    }
  }
}
</script>

<style lang="scss" scoped>
 .details {
    cursor: pointer;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 1;

    &:hover {
      border: 1px solid #51bafc;
    }
 }
 .card-content {
   padding: 0;
 }
</style>


