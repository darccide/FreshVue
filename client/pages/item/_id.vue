<template>
    <div>
        <h1 class="title is-1">{{ item.itemName }}</h1>
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
    computed: mapState({
        item: state => state.items.item
    })
}
</script>

<style lang="scss" scoped>

</style>