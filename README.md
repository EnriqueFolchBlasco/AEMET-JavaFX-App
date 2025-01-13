# AEMET-JavaFX-App
AEMET JavaFX App, MY LOVELY "Waether app (I am aware it's weather, just a joke name)".

This is my second app since I have started learning java, it gives the choice to select a town or city from Spain, with its province and community, to later show the weather of that town from the day you are in to 7 days forward. To achieve this, I use the AEMET page via XML, reading the files, etc.

Plus, it uses a panel from FXML one time and duplicates it to save elements.

## "Step by step" of how the filter works in order to obtain the region/town/city code.

<h4>First of all, you will need to introduce a autonomous communitie.</h4>

![filtro1](https://github.com/user-attachments/assets/d884d3da-8741-404b-8cba-2ac1f8f16f6a)


![filtro2](https://github.com/user-attachments/assets/9e2c136e-d11b-4d6d-aa50-09b9d4d8f971)

<h4>Afterwards, choose a province of the autonomous communitie you have picked, at this point they will had been filtered.</h4>


![filtro3](https://github.com/user-attachments/assets/c0241b21-7eba-4f57-bd03-c5ee40393b54)


<h4>The next two images are kinda the same thing, they show the cities and towns of the province you have picked, the difference is that one is a choice box, and the other box is a autocomplete box, this means that if you write "al", all the cities or towns that contain "al" will be showed, and the ones who don't contain it, won't appear.</h4>

![filtro4](https://github.com/user-attachments/assets/9a3d769f-29a8-4272-8f5c-870a2c8bc62e)

![filtro5](https://github.com/user-attachments/assets/116bd4a1-1da0-4afb-a7bc-9f7815b7fdf3)

<h4>Now, after introducing all the data needed, a code will be formed, and the data will be extracted from the XML of the selected city or town, to later on show the 7 future days of the week, with some data of them and an image, for example the percentatge of rain, sun power, thermal sensitivity, etc..</h4>


![aplicacion1](https://github.com/user-attachments/assets/2d479c10-cb02-4d7b-85d9-68d2211a79c2)

> [!NOTE]  
> In case you try to search a city or town that doesn't exist, an exception will jump, which will notify you.
> 
![imageException](https://github.com/user-attachments/assets/ce4a0d2f-b1b5-4fa6-9d5f-03532d18e732)

<h4>This is a closer look of how each panel looks.</h4>

![pane1](https://github.com/user-attachments/assets/a7936631-4042-43c9-b04b-19aeeab62263)

<h4>This is the aspect of the XML from where the information is taken. In order to get it, you have to make the code of the town/City.</h4>

![data1](https://github.com/user-attachments/assets/653c936a-da96-435b-92af-9ce2bb1d7e12)
