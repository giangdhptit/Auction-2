import React, { Component } from 'react';
import { FormattedMessage } from 'react-intl';
import { connect } from 'react-redux';
import 'bootstrap/dist/css/bootstrap.min.css';  
import './AuctionManage.scss';
import {getAllAuctions} from '../../services/auctionService';
import { indexOf } from 'lodash';
import ModalAuction from './ModalAuction';
class AuctionManage extends Component {

    constructor(props) {
        super(props);
        this.state = { 
            arrAuctions:[],
            isOpenModalAuction:false,
            auction:{},
        }

    }

     componentDidMount() {
        // let response = await getAllAuctions();
        // console.log('auction',response)
         this.getAllAuctions();
        
     }
    getAllAuctions=()=>  {
        const res =  fetch("http://localhost:8080/Auctions",{
            method : "GET",
            headers : {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },


        }).then((response) => response.json())
        .then((responseJson) => {

            console.log(responseJson);
            if (responseJson){
                //console.log('111111')
                this.setState({
                    arrAuctions : responseJson
                })
            }

            });


    }
    handleBid = (auctionBid) =>{
         this.setState({
             isOpenModalAuction:true,
             auction:auctionBid,

         })
    }

    toggleAuctionModal = () => {
        this.setState({
            isOpenModalAuction : !this.state.isOpenModalAuction,
        })
    }

    createNewBid = ( bid_price)=>{
        console.log('auction state',this.state.auction)
        console.log('user  : ',window.localStorage.getItem("user"))
        if (bid_price<this.state.auction.currentPrice) {
            alert('Please enter a higher price (>current price)')
        } else if (bid_price<this.state.auction.initPrice){
            alert('Please enter a higher price (>=init price)')
        } else {
            const resBid = fetch("http://localhost:8080/Bids/add",{
                method : "POST",
                headers : {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body : JSON.stringify({
                    bid_price : bid_price,
                    auction : this.state.auction,
                    user : JSON.parse(localStorage.getItem('user')),
                })

            }).then((response) => response.json())
            .then((responseJson) => {

                console.log(responseJson);
                if (responseJson.status=='ok'){
                    alert('Bid successfully')
                }
                return responseJson.user;
                });

                const resAuction = fetch("http://localhost:8080/Bids/add",{
                    method : "POST",
                    headers : {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body : JSON.stringify({
                        bid_price : bid_price,
                        auction : this.state.auction,
                        user : JSON.parse(localStorage.getItem('user')),
                    })
    
                }).then((response) => response.json())
                .then((responseJson) => {
    
                    console.log(responseJson);
                    if (responseJson.status=='ok'){
                        alert('Bid successfully')
                    }
                    return responseJson.user;
                    });
        }
    }
    render() {
        //console.log('render',this.state);
        const arrAuctions = this.state.arrAuctions;

        return (

            <div className="auction-container">
                <ModalAuction 
                    isOpen = {this.state.isOpenModalAuction}
                    toggleFromParent={this.toggleAuctionModal}
                    createNewBid={this.createNewBid}
                    auctionModal = {this.state.auction}
                />
                <ul className="responsive-table">
                    <li className="table-header">
                        <div className="col col-1">No</div>
                        <div className="col col-2">Item Name</div>
                        <div className="col col-3">Start at</div>
                        <div className="col col-4">End at</div>
                        <div className="col col-5">Init price</div>
                        <div className="col col-6">Current price</div>
                        <div className="col col-7">Actions</div>
                    </li>

                        {
                            

                            arrAuctions && arrAuctions.map((auction, index)=>{
                                
                                return(
                                    <li className="table-row">
                                        <div className="col col-1" data-label="Job Id">{index+1}</div>
                                        <div className="col col-2" data-label="Customer Name">{auction.item.name}</div>
                                        <div className="col col-3" data-label="Amount">{auction.start_at}</div>
                                        <div className="col col-4" data-label="Payment Status">{auction.end_at}</div>
                                        <div className="col col-5" data-label="Payment Status">{auction.initPrice}</div>
                                        <div className="col col-6" data-label="Payment Status">{auction.currentPrice}</div>
                                        <div className="col col-7" data-label="Payment Status">
                                            {/* <button>
                                                EDIT
                                            </button>
                                            <button>DELETE</button> */}
                                            <button onClick={()=>{this.handleBid(auction)}}>BID</button>
                                        </div>

                                    </li>
                                )
                              
                            })
                        }
     
                </ul>
            </div>
        );
    }

}

const mapStateToProps = state => {
    return {
    };
};

const mapDispatchToProps = dispatch => {
    return {
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(AuctionManage);
