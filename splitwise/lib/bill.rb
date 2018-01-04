class Bill
  attr_accessor :amount, :members, :paid_by

  def initialize
    self.members = []
  end

  def balance_with(user)
    if user == paid_by
      share * (members.size - 1)
    elsif members.include? user
      -share
    else
      0
    end
  end

  def share
    amount.to_f / members.size
  end
end
az
