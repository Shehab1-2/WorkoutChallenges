import './App.css';
import { useEffect, useState } from 'react';
import ChallengeList from './components/ChallengeList'
import axios from 'axios';
import AddChallenge from './components/AddChallenge';
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
    <div className="App">
      <h1>Monthly Challenege</h1>
      <AddChallenge onChallengeAdded={handleChallengeAdded}/>
      <ChallengeList challenges={challenges}/>
    </div>
  );
}

export default App;
