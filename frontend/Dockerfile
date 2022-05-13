# --- reactjs ---
FROM node:18.1.0-slim

# set working directory
WORKDIR /frontend/drinkerly
COPY ./drinkerly .
#COPY package*.json ./

RUN npm install
 
EXPOSE 3000

CMD [ "npm", "start" ]