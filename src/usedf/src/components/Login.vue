<template>
   <v-app>
      <v-container class="pa-10" id="container">
         <v-row  align="center" id="row">
            <v-col>
               <h1 style="font-size: 40px; text-align: center"  class="primary--text">Login</h1>
               <v-text-field
               label="e-mail"
               required
               class="mt-5"
               ></v-text-field>
               <v-text-field
               class="mt-5 mb-10"
               label="password"
               required
               ></v-text-field>
               <v-btn @click="signup({
                address,
                  email,
                  username,
                  password,
                  phone
                  })"
                block
                x-large
                class="primary"
                >확인</v-btn>
            </v-col>
         </v-row>

      </v-container>
   </v-app>
</template>
<style>

.container{
   width: 100%;
   height: 100%;
}
.row{
   width: 100%;
   height: 100%;

}

</style>