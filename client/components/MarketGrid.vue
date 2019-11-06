<template>
    <div class="marketgrid">
        <div class="columns is-centered is-multiline">
                <ItemCard
                    v-for="(item, index) in items"
                    :key="index"
                    :item="item"
                    :data-index="index"
                    class="item"
                />
        </div>
    </div>
</template>
<script>
import ItemCard from '@/components/ItemCard.vue'
import { mapState } from 'vuex'
export default {
  head() {
    return {
      title: 'FreshVue Market',
    }
  },
  async fetch({ store, error }) {
    try {
      await store.dispatch('items/fetchItems')
    } catch(e) {
      error({ 
        statusCode: 503, 
        message: 'Unable to fetch items at this time. Please try again.'
      })
    }
  },
  components: {
    ItemCard
  },
  computed: mapState({
    items: state => state.items.items
  })
}
</script>
<style lang="scss" scoped>
  .marketgrid {
    cursor: pointer;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 1;
  }
  .item {
    background-color: hsl(141, 71%, 48%);
    color: hsl(0, 0%, 96%);
    max-height: 30em;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    margin: 0px 0;
  }
</style>