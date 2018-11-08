using MilitaryElitePractice.Enums;

namespace MilitaryElitePractice.Contracts
{
    public interface IMission
    {
        string CodeName { get; }
        State State { get; }
    }
}
