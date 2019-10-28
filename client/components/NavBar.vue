<template>
    <nav class="navbar" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <nuxt-link to="/" class="navbar-item has-text-success is-size-1">
                FreshVue
            </nuxt-link>

            <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false">
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
            </a>
        </div>

        <div class="navbar-menu">
            <div class="navbar-end">
                <nuxt-link to="/" class="navbar-item">
                    List
                </nuxt-link>

                <nuxt-link to="/item/display" class="navbar-item">
                    Item
                </nuxt-link>
            </div>
        </div>
    </nav>
</template>

<script>
    export default {
        
    }
</script>

<style lang="scss" scoped>

</style>