import './App.css';
import { useEffect, useState } from 'react';
import ChallengeList from './components/ChallengeList'
import axios from 'axios';
import AddChallenge from './components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
  
    const [challenges, setChallenges] = useState([]);
    useEffect(() =>{
      fetchChallenge();
    }, []);

    const fetchChallenge = async () => {
      try {
        const response = await axios.get('http://localhost:8080/challenges')
        setChallenges(response.data)
      } catch (error) {
        console.error("Error fetching challenge ", error);
      }
      
    };

    const handleChallengeAdded = () => {
      fetchChallenge();
    };

 return (
    <div className="container mt-5">
      <h1 className='text-center mb-4'> Monthly Challenege</h1>
      <AddChallenge onChallengeAdded={handleChallengeAdded}/>
      <ChallengeList challenges={challenges}/>
    </div>
  );
}

export default App;
