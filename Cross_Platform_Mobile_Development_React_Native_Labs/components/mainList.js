import React from 'react';
import {SafeAreaView, View, FlatList, StyleSheet, Text, StatusBar, Image, Button, Alert} from 'react-native';
import {useNavigation} from '@react-navigation/native';



const MainList = ({PRODUCTS}) => {
    const navigation = useNavigation();
    const renderItem = ({item}) => (
        <View style={styles.item}>
            <Image source={{uri: item.image}}
                   style={styles.productPic}/>
            <Text style={styles.title}>{item.title}</Text>
            <View style={styles.btnContainer}>
                <Button
                    title="Show Details"
                    onPress={() => navigation.navigate("Details",{
                        item: item,
                    })}
                />
            </View>

        </View>
    );

    return (
        <SafeAreaView style={styles.container}>
            <FlatList
                data={PRODUCTS}
                renderItem={renderItem}
                keyExtractor={(item, index) => index.toString()}
            />
        </SafeAreaView>
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
    }
});

export default MainList;