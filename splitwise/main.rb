Dir["./lib/*.rb"].each { |file| load file }

def add_friend(name)
  @users << User.new(name)
  "Added Friend: #{@users.size - 1}. #{name}"
end

def friends
  @users[1..@users.size]
end

def add_bill(amount, paid_by_i, *args)
  bill = Bill.new
  bill.amount = amount
  if args.empty?
    # Add the bill to everyone
    @users.each do |user|
      bill.members << user
    end
  else
    args.each do |i|
      bill.members << @users[i]
    end
  end

  bill.paid_by = @users[paid_by_i]

  @bills << bill

  "Splitting #{amount} among #{bill.members.size} people. Paid by #{bill.paid_by.name}"
end

def show_balances
  puts "Balances:"
  @users.each do |friend|
    if friend == @users[0]
      balance = friend.balance(@bills)
    else
      balance = friend.balance_with(friend, @bills)
    end
    status = if balance == 0
      'Settled Up'
    elsif balance > 0
      "Owes you #{balance.round(2)}"
    else
      "You Owe  #{-balance.round(2)}"
    end
    puts "    #{friend.name}\t- #{status}"
  end
  puts
end

def show_friends
  puts "Friends:"
  @users.each_with_index do |friend, i|
    puts "#{i}. #{friend.name}"
  end
  puts
end

def setup
  @users = []
  @bills = []

  @users << User.new('You.')
end

def seed
  puts add_bill(100, 0)
  show_balances
  puts add_friend('Ladia')
  puts add_bill(200, 0)
  show_balances
  puts add_bill(300, 1)
  show_balances
  puts add_friend('Gopi')
  puts add_friend('Kaushal')
  puts add_friend('Mishra')
  show_balances

  puts add_bill(1000, 2)

  show_friends
  show_balances
end

setup
seed

puts %{
====== SPLITWISE ======
you can:
  add_friend
  add_bill(amount, paid_by, IDs) : If IDs is blank, bill is added to everyone
  show_friends
  show_balances

}
