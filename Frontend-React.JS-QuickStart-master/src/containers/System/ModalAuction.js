import React, { Component } from 'react';
import { FormattedMessage } from 'react-intl';
import { connect } from 'react-redux';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import { transpileModule } from 'typescript';
class ModalAuction extends Component {

    constructor(props){
        super(props);
        this.state = {
            bid_price:''
        }
    }

    state = {

    }

    componentDidMount() {
    }

    toggle = ()=>{
        this.props.toggleFromParent();
    }
    checkValidInput = () => {
        let isValid = true;
        if ((!this.state.bid_price) ){
            isValid = false;
            alert('Please enter Bid price')
        }
        return isValid;
    }

    handleOnChangeInput = (event) => {

        this.setState({
            bid_price: event.target.value
        })
        //console.log(this.state.bid_price)
    }

    handleNewBid = () =>{
        let isValid =this.checkValidInput();
        if (isValid===true){
            this.props.createNewBid(this.state.bid_price);
        }
    }
    render() {
        // console.log('check props ',this.props);
        // console.log(this.props.isOpen);
        
        return (
            <Modal 

                isOpen={this.props.isOpen} 
                toggle={()=>{this.toggle()}} 
                className={'modalClassName'}
                size="lg"
                centered
            >
                <ModalHeader toggle={()=>{this.toggle()}}>Bid</ModalHeader>
                <ModalBody>
                    <div className='container'>
                        <div className="row">
                            <div className="col-6 form group">
                                <label>Bid price</label>
                                <input 
                                    type="number" 
                                    value = {this.state.bid_price}
                                    onChange={(event)=>this.handleOnChangeInput(event)}
                                    //
                                    />
                            </div>
                        </div>
                    </div>
                </ModalBody>
                <ModalFooter>
                    <Button color="primary" onClick={()=>{this.handleNewBid()}}>
                        Bid
                    </Button>{' '}
                    <Button color="secondary" onClick={()=>{this.toggle()}}>
                        Cancel
                    </Button>
                </ModalFooter>
            </Modal>
        )
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

export default connect(mapStateToProps, mapDispatchToProps)(ModalAuction);


