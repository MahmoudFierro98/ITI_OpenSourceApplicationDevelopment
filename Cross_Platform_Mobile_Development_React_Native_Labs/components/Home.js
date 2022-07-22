import {useState} from "react";
import {ImageBackground, StyleSheet, Text, View} from "react-native";
import MainList from "./mainList";
import {StatusBar} from "expo-status-bar";

const image = {uri: "https://c1.wallpaperflare.com/preview/945/664/948/cosmetics-tools-lipstick-accessories.jpg"}
export default function Home({navigation}) {

    const [products, setProducts] = useState([
        {
            id: 1,
            title: 'White&Black Blouse',
            description:"some text here to descripe that awsome blouse",
            image: 'https://c1.wallpaperflare.com/preview/608/922/468/eye-shadow-cosmetics-color-palette-color.jpg'

        },
        {
            id: 2,
            title: 'White Florie Blouse',
            description:"some text here to descripe that awsome blouse",
            image: 'https://c1.wallpaperflare.com/preview/525/746/556/manicure-pedicure-cosmetics-kosmetikstudio.jpg'
        },
        {
            id: 3,
            title: 'Red Florie Dress',
            description:"some text here to descripe that awsome blouse",
            image: 'https://c1.wallpaperflare.com/preview/907/317/312/lipstick-pink-beauty-mac.jpg'
        }, {
            id: 4,
            title: 'Pink Blouse',
            description:"some text here to describe that awesome blouse",
            image: 'https://c1.wallpaperflare.com/preview/402/407/725/beauty-cosmetic-make-up-lipstick.jpg'
        },
    ]);

    return (
        <View style={styles.container}>
            <ImageBackground source={image} resizeMode="cover" style={styles.image}>
                <Text style={styles.title}>Makeup App</Text>

                <MainList PRODUCTS={products}/>
                <StatusBar style="auto"/>
            </ImageBackground>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#4086cb',

    },
    image: {
        flex: 1,
        justifyContent: "center"
    },
    title: {
        paddingTop: 30,
        paddingLeft: 10,
        fontSize: 24,
        fontWeight: 'bold',
        color: 'white',
        textAlign: 'left'
    },
});
