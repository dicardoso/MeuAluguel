<script setup lang="ts">
import { ref, shallowRef } from 'vue'
import sidebarItems from './vertical-sidebar/sidebarItem'
import NavGroup from './vertical-sidebar/NavGroup/index.vue'
import NavItem from './vertical-sidebar/NavItem/index.vue'
import Logo from './logo/Logo.vue'
// Icon Imports
import { Menu2Icon, BellRingingIcon } from 'vue-tabler-icons'
import NotificationDD from './vertical-header/NotificationDD.vue'
import ProfileDD from './vertical-header/ProfileDD.vue'

const sidebarMenu = shallowRef(sidebarItems)
const sDrawer = ref(true)
</script>

<template>
  <v-navigation-drawer
    v-model="sDrawer"
    left
    app
    class="leftSidebar ml-sm-5 mt-sm-5 bg-containerBg"
    elevation="10"
    width="270"
  >
    <div class="pa-5 pl-4 ">
      <Logo />
    </div>
    <!-- ---------------------------------------------- -->
    <!---Navigation -->
    <!-- ---------------------------------------------- -->
    <perfect-scrollbar class="scrollnavbar bg-containerBg overflow-y-hidden">
      <v-list class="py-4 px-4 bg-containerBg">
        <!---Menu Loop -->
        <template v-for="(item, i) in sidebarMenu">
          <!---Item Sub Header -->
          <NavGroup
            v-if="item.header"
            :key="item.title"
            :item="item"
          />
          <!---Single Item -->
          <NavItem
            v-else
            :item="item"
            class="leftPadding"
          />
          <!---End Single Item -->
        </template>
        <!-- <Moreoption/> -->
      </v-list>
      <div class="py-0 px-6">
        <v-btn
          class="mr-2 bg-primary rounded-pill"
          size="large"
          href="https://www.wrappixel.com/templates/spike-vuejs-admin-dashboard/?ref=33"
          block
          target="_blank"
        >
          Upgrade to
          Pro
        </v-btn>
      </div>
    </perfect-scrollbar>
  </v-navigation-drawer>
  <div class="container verticalLayout">
    <div class="maxWidth">
      <v-app-bar
        elevation="0"
        height="70"
      >
        <div class="d-flex align-center justify-space-between w-100">
          <div>
            <v-btn
              class="hidden-lg-and-up text-muted"
              icon
              variant="flat"
              size="small"
              @click="sDrawer = !sDrawer"
            >
              <Menu2Icon
                size="20"
                stroke-width="1.5"
              />
            </v-btn>
            <!-- Notification -->
            <NotificationDD />
          </div>
          <div>
            <!-- Upgrade button -->
            <v-btn
              class="mr-2 bg-primary rounded-pill"
              href="https://www.wrappixel.com/templates/spike-vuejs-admin-dashboard/?ref=33"
              target="_blank"
            >
              Upgrade to Pro
            </v-btn>
            <!-- User Profile -->
            <ProfileDD />
          </div>
        </div>
      </v-app-bar>
    </div>
  </div>
</template>
