<template>
    <div class="card column is-one-third">
      <div class="card-image">
        <figure class="image-contain">
          <nuxt-link :to="'/item/' + item.itemId">
            <img :src="getImgUrl(item.image)" :alt="item.itemName" class="item-img">
          </nuxt-link>
        </figure>
      </div>
      <div class="card-content">
        <div class="media">
          <div class="media-content">
            <p class="is-pulled-right">
              <span class="title is-5 has-text-light">{{ item.itemName }} </span>
              <span class="title is-5 has-text-light">|  Price &#36;{{ item.price }}</span>
            </p>
          </div>
        </div>
        <div class="card-footer">
          <div class="card-footer-item">
            <nuxt-link :to="'/item/' + item.itemId">
              <button class="button is-fullwidth is-success is-light">
                <span class="icon is-small">
                  <i class="fa fa-eye"></i>
                </span>
                <span>View Item</span>
              </button>
            </nuxt-link>
          </div>
        </div>
      </div>
    </div>
  
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
 .image-contain {
    padding-top: 8em;
    max-height: 60em;
    display: flex;
    align-content: center;
    align-items: center;
    img {
      position: relative;
      float: left;
      width:  16em;
      height: 14em;
      background-position: 50% 50%;
      background-repeat:   no-repeat;
      background-size:     cover;
    }
  }
 .card-content {
   padding-top: 15px;
 }
</style>


