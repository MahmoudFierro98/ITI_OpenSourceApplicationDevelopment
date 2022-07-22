import React from 'react';
import {Alert, Button, Image, StatusBar, StyleSheet, Text, View} from "react-native";

export default function Details({route,navigation}) {
    const {item} = route.params;
    return (
        <View style={styles.container}>
            <View style={styles.item}>
          <Text style={styles.title}>Makeup Code: {item.id}</Text>
            <Image source={{uri: item.image}}
                   style={styles.productPic}/>
            <Text style={styles.title}>{item.title}</Text>
                <Text style={styles.title}>{item.description}</Text>
            </View>
            <View style={styles.btnsContainer}>
                <Button title="Go to Home" onPress={() => navigation.navigate('Home')}/>
                <Button title="Go back" onPress={() => navigation.goBack()} />
            </View>


        </View>
    );
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginTop: StatusBar.currentHeight || 0,
    },
    item: {
        backgroundColor: '#c2c2c2',
        padding: 10,
        marginVertical: 4,
        marginHorizontal: 16,
        // borderWidth:1.5,
        // borderColor:'#01fd23',
        borderRadius: 30,
    },
    title: {
        fontSize: 18,
        fontWeight: 'bold',
        textAlign: 'left',
        marginTop: 2,
        fontFamily: 'Roboto',
        fontStyle: 'italic',
        marginLeft: 4
    },
    productPic: {
        width: '100%',
        height: 200,
        borderRadius: 30
    },
    btnContainer: {
        width: '40%',
        alignSelf: 'center',
        marginBottom: 5,
        marginTop: 5
    },
    btnsContainer: {
        marginLeft:30,
        marginRight:30,
        flexDirection: 'row',
        justifyContent: 'space-between',
    },
});

