import { useState } from "react";
import axios from 'axios';

function AddChallenge({onChallengeAdded}){
    const [month, setMonth] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async(e) => {
        e.preventDefault();
        try{
            await axios.post('http://localhost:8080/challenges',{month,description})
            setMonth('');
            setDescription('');
            onChallengeAdded();
        }catch (error) {
            console.error("Error adding challenge ", error);
        }
    }

    return(
    <div className="card my-5">
        <div class="card-header"> Add New Challenege</div>
            
            <div className="card-body">
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlfor="month" className="form-label">Month</label>
                    <input type="text" className="form-control" placeholder="e.g., Jan" id="month" value={month} onChange={(e) => setMonth(e.target.value)}required></input>
                </div>

                <div className="mb-3">
                    <label htmlfor="description" className="form-label">Description</label>
                    <input id="description" className="form-control" placeholder="Describe the Challenge" value={description} onChange={(e) => setDescription(e.target.value)}required></input>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            </div>
    </div>
    )
}

export default AddChallenge;