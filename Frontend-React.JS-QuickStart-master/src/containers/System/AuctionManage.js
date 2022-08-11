import React, { Component } from 'react';
import { FormattedMessage } from 'react-intl';
import { connect } from 'react-redux';
import 'bootstrap/dist/css/bootstrap.min.css';  
import './AuctionManage.scss';
import {getAllAuctions} from '../../services/auctionService';
import { indexOf } from 'lodash';
class AuctionManage extends Component {

    constructor(props) {
        super(props);
        this.state = { 
            arrAuctions:[]
        }

    }

    async componentDidMount() {
        // let response = await getAllAuctions();
        // console.log('auction',response)
        const res = fetch("http://localhost:8080/Auctions",{
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
                return responseJson.user;
                });

    }
    handleBid = () =>{
         
    }

    render() {
        console.log('render',this.state);
        let arrAuctions = this.state.arrAuctions;
        console.log('arr',arrAuctions);
        return (

            <div className="auction-container">
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
                    <li className="table-row">
                        {

                            arrAuctions && arrAuctions.map((auction, index)=>{

                                console.log("check map", auction, index)
                                return(
                                    <>
                                        <div className="col col-1" data-label="Job Id">{index+1}</div>
                                        <div className="col col-2" data-label="Customer Name">{auction.item.name}</div>
                                        <div className="col col-3" data-label="Amount">{auction.start_at}</div>
                                        <div className="col col-4" data-label="Payment Status">{auction.end_at}</div>
                                        <div className="col col-5" data-label="Payment Status">{auction.initPrice}</div>
                                        <div className="col col-6" data-label="Payment Status">{auction.currentPrice}</div>
                                        <div className="col col-7" data-label="Payment Status">
                                            <button>
                                                EDIT
                                            </button>
                                            <button>DELETE</button>
                                            <button onClick={()=>{this.handleBid()}}>BID</button>
                                        </div>

                                    </>
                                )
                            })
                        }
                        {/* <div className="col col-1" data-label="Job Id">42235</div>
                        <div className="col col-2" data-label="Customer Name">John Doe</div>
                        <div className="col col-3" data-label="Amount">$350</div>
                        <div className="col col-4" data-label="Payment Status">Pending</div>
                        <div className="col col-5" data-label="Payment Status">Init price</div>
                        <div className="col col-6" data-label="Payment Status">Current price</div> */}
                    </li>
                    
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
