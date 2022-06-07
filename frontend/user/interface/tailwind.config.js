module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors:{
        'primary':{
          DEFAULT:'#C1121F',
          'tint':{
            '1':'#D31420',
            '2':'#E71523',
            '3':'#EB2734',
            '4':'#ED3A46',
            '5':'#EF4E59',
            '6':'#F0626B',
            '7':'#F2757E',
            '8':'#F48990',
            '9':'#F69DA3',
            '10':'#F8B0B5',
            '11':'#FAC4C8',
          },
          'shade':{
            '1':'#B2111B',
            '2':'#A40F19',
            '3':'#960E17',
            '4':'#890D15',
            '5':'#7B0B13',
            '6':'#6D0A11',
          }
        },
      }
    },
  },
  plugins: [],
}
