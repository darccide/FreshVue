<template>
  <nuxt-link :to="'/item/' + item.itemId">
    <div class="card column">
      <div class="card-image">
        <figure class="image is-4by3">
          <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Placeholder image">
        </figure>
      </div>
      <div class="card-content">
        <div class="media">
          <div class="media-content">
            <p class="title is-4">{{ item.itemName }}</p>
          </div>
        <div class="content is-clearfix">
          <p>{{ item.itemDescription }}</p>
        </div>
        <div class="is-pulled-left">
            <span class="title is-5"><strong>Inventory: {{ item.inventory }}</strong></span>
        </div>
          <p class="is-pulled-right">
            <span class="title is-5"><strong>&#36; {{ item.price }}</strong></span>
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


