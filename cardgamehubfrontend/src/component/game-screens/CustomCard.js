// Component representing a custom card
const CustomCard = ({ card, onClick }) => {
    // Function to get the symbol corresponding to the card's suit
    const getSuitSymbol = (suit) => {
        const symbols = {
            diamonds: '♦',
            clubs: '♣',
            hearts: '♥',
            spades: '♠'
        };
        return symbols[suit];
    };

    // Render the custom card
    return (
        <div style={{
            // Styling for the card
            height: "70px",
            width: "50px",
            margin: "10px",
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "center",
            background: "#fff",
            border: "1px solid #000",
            borderRadius: "8px",
            boxShadow: "0 2px 10px rgba(0,0,0,0.3)",
            color: card.suit === 'diamonds' || card.suit === 'hearts' ? 'red' : 'black',
            fontFamily: "'Times New Roman', serif",
            position: 'relative',
            fontSize: '18px',
            cursor: 'pointer'
        }} onClick={() => onClick(card)}>
            {/* Render the rank and suit of the card */}
            <div style={{ position: 'absolute', top: '5px', left: '5px' }}>
                <div style={{ fontSize: '12px' }}>{card.rank}</div>
                <div style={{ fontSize: '9px' }}>{getSuitSymbol(card.suit)}</div>
            </div>
            <div style={{ fontSize: '24px' }}>{getSuitSymbol(card.suit)}</div>
            <div style={{ position: 'absolute', bottom: '5px', right: '5px', transform: 'rotate(180deg)' }}>
                <div style={{ fontSize: '12px' }}>{card.rank}</div>
                <div style={{ fontSize: '9px' }}>{getSuitSymbol(card.suit)}</div>
            </div>
        </div>
    );
};

export default CustomCard;