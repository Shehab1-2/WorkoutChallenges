import Challenege from "./Challenge";
function ChallengeList({challenges}) {
    return(
        <div>
            {challenges.map(challenge =>(
                <Challenege key={challenge.id}
                challenge={challenge}/>


            ))}
        </div>
    );
}

export default ChallengeList